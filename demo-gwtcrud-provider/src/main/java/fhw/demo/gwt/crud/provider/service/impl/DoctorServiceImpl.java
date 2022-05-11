package fhw.demo.gwt.crud.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fhw.demo.gwt.crud.provider.mapper.DoctorMapper;
import fhw.demo.gwt.crud.provider.model.Doctor;
import fhw.demo.gwt.crud.provider.service.DoctorService;
import fhw.demo.gwt.crud.provider.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:00
 */

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findAll() {
        LambdaQueryWrapper<Doctor> queryWrapper = WrapperUtils.getQueryWrapper();
        return doctorMapper.selectList(queryWrapper);
    }

    @Override
    public void add(Doctor doctor) {
        doctorMapper.insert(doctor);
    }

    @Override
    public int modify(Doctor doctor) {
        return doctorMapper.updateById(doctor);
    }

    @Override
    public Doctor findById(Long id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public boolean delete(Long id) {

        int i = doctorMapper.deleteById(id);
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Doctor> findByCondition(String condition) {
        LambdaQueryWrapper<Doctor> queryWrapper = WrapperUtils.getQueryWrapper();
        queryWrapper.like(Doctor::getName, condition).or().eq(Doctor::getJobNumber, condition);
        return doctorMapper.selectList(queryWrapper);
    }
}
