package service;

import entity.City;

import java.util.List;

/**
 * @author 张睿
 * @date 2018/11/26 13:22
 * 逻辑接口类
 */
public interface CityService {
    List<City> findAllCity();
    City findCityById(Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
