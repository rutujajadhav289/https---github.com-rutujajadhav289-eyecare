package com.doctorlogin.doctor.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doctorlogin.doctor.Entity.Doctor;
import com.doctorlogin.doctor.Exception.ResourceNotFoundException;
import com.doctorlogin.doctor.Repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
List<Doctor> list;
	
	public DoctorServiceImpl() {
		list = new ArrayList<>();
		list.add(new Doctor(1,"Rutuja","Jadhav","rutuja@gmail.com","Pune","Female","Doctor","DR12345","7768098324","rutuja123","rutuja123"));
	}

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {

		return doctorRepository.save(doctor);
	}
	
	@Override
	public List<Doctor> getAllDoctors() {

		return doctorRepository.findAll();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, Integer id) {

		Doctor existingDoctor = this.doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor","Id",id));
		existingDoctor.setFirst_name(doctor.getFirst_name());
		existingDoctor.setLast_name(doctor.getLast_name());
		existingDoctor.setEmail(doctor.getEmail());
		existingDoctor.setGender(doctor.getGender());
		existingDoctor.setRole(doctor.getRole());
		existingDoctor.setLicenseNo(doctor.getLicenseNo());
		existingDoctor.setPhoneNo(doctor.getPhoneNo());
		existingDoctor.setPassword(doctor.getPassword());
		
		doctorRepository.save(existingDoctor);
		return existingDoctor;
	}


	@Override
	public void deleteEmployee(Integer id) {
		
		doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor","Id",id));
		doctorRepository.deleteById(id);
	}


}
