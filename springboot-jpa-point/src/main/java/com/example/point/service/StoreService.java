
package com.example.point.service;

import com.example.point.model.Direction;
import com.example.point.model.Location;
import com.example.point.model.PaginationResponse;
import com.example.point.model.StoreResponse;
import com.example.point.util.GeometryUtil;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final EntityManager em;

    @Transactional(readOnly = true)
    public PaginationResponse getNearByStore(Double latitude, Double longitude, int count) {

        Double distance = 1.0;

        Location northEast = GeometryUtil
                .calculate(latitude, longitude, distance, Direction.NORTHEAST.getBearing());
        Location southWest = GeometryUtil
                .calculate(latitude, longitude, distance, Direction.SOUTHWEST.getBearing());

        double x1 = northEast.getLatitude();
        double y1 = northEast.getLongitude();
        double x2 = southWest.getLatitude();
        double y2 = southWest.getLongitude();

        String pointFormat = String.format("'LINESTRING(%f %f, %f %f)')", x1, y1, x2, y2);

        String distanceFormat = String.format("ST_DISTANCE_SPHERE(POINT(%f, %f), POINT(ST_Y(location), ST_X(location)))", longitude, latitude);

        Query query = em.createNativeQuery("SELECT s.id as id, s.name as name, "
                        + distanceFormat + " as distance, "
                        + "s.address as address, s.thumbnail as thumbnail, ST_X(s.location) as lat, ST_Y(s.location) as lng  "
                        + "FROM store AS s "
                        + "WHERE MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + ", s.location) "
                        + "ORDER BY distance asc "
                        + "limit " + count +";");

        JpaResultMapper result = new JpaResultMapper();
        List<StoreResponse> list = result.list(query, StoreResponse.class);

        if(list.size()<count){
            distance += 1;

            northEast = GeometryUtil
                    .calculate(latitude, longitude, distance, Direction.NORTHEAST.getBearing());
            southWest = GeometryUtil
                    .calculate(latitude, longitude, distance, Direction.SOUTHWEST.getBearing());

            x1 = northEast.getLatitude();
            y1 = northEast.getLongitude();
            x2 = southWest.getLatitude();
            y2 = southWest.getLongitude();

            pointFormat = String.format("'LINESTRING(%f %f, %f %f)')", x1, y1, x2, y2);

            distanceFormat = String.format("ST_DISTANCE_SPHERE(POINT(%f, %f), POINT(ST_Y(location), ST_X(location)))", longitude, latitude);

            query = em.createNativeQuery("SELECT s.id as id, s.name as name, "
                    + distanceFormat + " as distance, "
                    + "s.address as address, s.thumbnail as thumbnail, ST_X(s.location) as lat, ST_Y(s.location) as lng  "
                    + "FROM store AS s "
                    + "WHERE MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + ", s.location) "
                    + "ORDER BY distance asc "
                    + "limit " + count +";");

            list = result.list(query, StoreResponse.class);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("storeList", list);

        return new PaginationResponse(map, list.size());
    }
}
