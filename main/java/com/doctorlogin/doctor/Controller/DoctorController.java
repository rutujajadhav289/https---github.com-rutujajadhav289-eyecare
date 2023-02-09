package com.doctorlogin.doctor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorlogin.doctor.Entity.Doctor;
import com.doctorlogin.doctor.Services.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	
	//create new doctor
	@PostMapping("sign-up")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
	//update existing doctor
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") Integer id, @RequestBody Doctor doctor){
		
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, id),HttpStatus.OK);	
	}
	
	@GetMapping("/list")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Integer id){
		
		 doctorService.deleteEmployee(id);
		 return new ResponseEntity<String>("Doctor deleted successfully!.",HttpStatus.OK);
	}
}
