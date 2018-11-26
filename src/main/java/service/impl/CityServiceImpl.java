package service.impl;

import dao.CityDao;
import entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CityService;

import java.util.List;

/**
 * @author 张睿
 * @date 2018/11/26 13:22
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    public List<City> findAllCity() {
        return cityDao.findAllCity();
    }

    @Override
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }
}
