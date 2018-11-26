package dao;

import entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张睿
 * @date 2018/11/26 12:02
 * 城市DAO接口类
 */
@Repository
public interface CityDao {
    List<City> findAllCity();
    City findById(@Param("id") Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
