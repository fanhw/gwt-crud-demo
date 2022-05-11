package fhw.demo.gwt.crud.provider.biz.service;


import fhw.demo.crud.api.HandleService;
import fhw.demo.crud.dto.DoctorDTO;
import fhw.demo.gwt.crud.provider.model.Doctor;
import fhw.demo.gwt.crud.provider.service.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:12
 */

@Service
public class HandleServiceImpl implements HandleService {
    @Autowired
    private DoctorService doctorService;

    @Override
    public List<DoctorDTO> get(String condition) {
        List<Doctor> byCondition = doctorService.findByCondition(condition);
        List<DoctorDTO> result = byCondition.stream().map(doctor -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(doctor, doctorDTO);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(doctor.getBirth());
            doctorDTO.setBirthStr(format);
            doctorDTO.setBirth(doctor.getBirth());
            return doctorDTO;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public DoctorDTO add(DoctorDTO doctorDTO) {
        if (null != doctorDTO) {
            DoctorDTO doctorById = this.getById(doctorDTO.getId());
            if (null == doctorById.getId()) {
                Doctor doctor = new Doctor();
                doctor.setName(doctorDTO.getName());
                doctor.setBirth(doctorDTO.getBirth());
                doctor.setAge(doctorDTO.getAge());
                doctor.setJobNumber(doctorDTO.getJobNumber());
                doctorService.add(doctor);
                doctorDTO.setId(doctor.getId());
            } else {
                Doctor doctor = new Doctor();
                doctor.setName(doctorDTO.getName());
                doctor.setBirth(doctorDTO.getBirth());
                doctor.setAge(doctorDTO.getAge());
                doctor.setId(doctorDTO.getId());
                doctor.setJobNumber(doctorDTO.getJobNumber());
                doctorService.modify(doctor);
            }
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(doctorDTO.getBirth());
        doctorDTO.setBirthStr(format);
        return doctorDTO;
    }

    @Override
    public boolean delete(DoctorDTO doctorDTO) {
        return doctorService.delete(doctorDTO.getId());
    }

    @Override
    public DoctorDTO getById(Long id) {
        Doctor byId = doctorService.findById(id);
        DoctorDTO doctorDTO = new DoctorDTO();
        if(null!= byId) {
            doctorDTO.setId(byId.getId());
            doctorDTO.setName(byId.getName());
            String format = new SimpleDateFormat("yyyy-MM-dd").format(byId.getBirth());
            doctorDTO.setBirthStr(format);
            doctorDTO.setBirth(byId.getBirth());
            doctorDTO.setAge(byId.getAge());
            doctorDTO.setJobNumber(byId.getJobNumber());
        }
        return doctorDTO;
    }


    @Override
    public List<DoctorDTO> list() {
        List<Doctor> doctors = doctorService.findAll();
        List<DoctorDTO> collect = doctors.stream().map(doctor -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(doctor, doctorDTO);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(doctor.getBirth());
            doctorDTO.setBirth(doctor.getBirth());
            doctorDTO.setBirthStr(format);
            return doctorDTO;
        }).collect(Collectors.toList());
        return collect;
    }
}
