package fhw.demo.gwt.crud.consumer.server.web;


import fhw.demo.crud.api.HandleService;
import fhw.demo.crud.dto.DoctorDTO;
import org.apache.dubbo.config.ReferenceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 11:39
 */

@RestController
@RequestMapping("/test")
public class MyTestController {
    @Autowired
    private HandleService handleService;

//    @Autowired
//    @Qualifier("referenceConfig")
//    private ReferenceConfig referenceConfig;

    @RequestMapping(value = "/getDoctorById01/{id}", method = RequestMethod.GET)
    public DoctorDTO getDoctorById(@PathVariable("id") Long id) {
        return handleService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public DoctorDTO getDoctorById(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO result = handleService.add(doctorDTO);
        return result;
    }

//    @RequestMapping(value = "/getDoctorById02/{id}",method = RequestMethod.GET)
//    public DoctorDTO getDoctorById02(@PathVariable("id") Long id) {
//        HandleService handleService1 = (HandleService) referenceConfig.get();
//        return handleService1.get(id);
//    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getDoctorById01() {
        return "helloWorld";
    }


}
