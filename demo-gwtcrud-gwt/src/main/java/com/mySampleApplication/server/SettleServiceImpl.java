package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.DoctorDTO;
import com.mySampleApplication.client.ObtainService;
import fhw.demo.crud.api.HandleService;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 10:17
 */

public class SettleServiceImpl extends RemoteServiceServlet implements ObtainService {


    private final HandleService handleService = AppContext.getBean(HandleService.class);


    @Override
    public List<DoctorDTO> getDoctorListByIdOrName(String condition) {

        List<fhw.demo.crud.dto.DoctorDTO> doctorDTOS = handleService.get(condition);
        List<DoctorDTO> collect = doctorDTOS.stream().map(dto -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            if (null != dto.getId()) {
                BeanUtils.copyProperties(dto, doctorDTO);
            }
            return doctorDTO;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public DoctorDTO add(DoctorDTO doctorDTO) {

        fhw.demo.crud.dto.DoctorDTO result = new fhw.demo.crud.dto.DoctorDTO();
        result.setName(doctorDTO.getName());
        result.setBirth(doctorDTO.getBirthday());
        result.setId(doctorDTO.getId());
        result.setAge(doctorDTO.getAge());
        result.setJobNumber(doctorDTO.getJobNumber());
        handleService.add(result);
        return doctorDTO;
    }

    @Override
    public boolean delete(DoctorDTO person) {
        fhw.demo.crud.dto.DoctorDTO doctorDTO = new fhw.demo.crud.dto.DoctorDTO();
        doctorDTO.setId(person.getId());
        return handleService.delete(doctorDTO);
    }

    @Override
    public List<DoctorDTO> list() {
        List<fhw.demo.crud.dto.DoctorDTO> list = handleService.list();
        List<DoctorDTO> collect = list.stream().map(doctor -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(doctor, doctorDTO);
            doctorDTO.setBirthday(doctor.getBirth());
            doctorDTO.setBirthStr(doctor.getBirthStr());
            return doctorDTO;
        }).collect(Collectors.toList());
        return collect;
    }


}
