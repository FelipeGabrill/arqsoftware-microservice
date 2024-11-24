package com.ucsal.arqsoftware.proxy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ucsal.arqsoftware.response.PhysicalSpace;
import com.ucsal.arqsoftware.response.PhysicalSpaceType;

public interface PhysicalSpaceProxy {

	@GetMapping(value = "http://localhost:8100/physicalspaces")
	public Page<PhysicalSpace> getPhysicalSpace(Pageable pageable);
	
	@GetMapping(value = "http://localhost:8100/physicalspaces/{id}")
	public PhysicalSpace getPhysicalSpaceById(Long id);
	
	@PostMapping(value = "http://localhost:8100/physicalspaces")
	public PhysicalSpace postPhysicalSpace(PhysicalSpace physicalSpace);
	
	@PutMapping(value = "http://localhost:8100/physicalspaces/{id}")
	public PhysicalSpace putPhysicalSpace(Long id, PhysicalSpace physicalSpace);
	
	@DeleteMapping(value = "http://localhost:8100/physicalspaces/{id}")
	public Void deletePhysicalSpace(Long id);
	
	@GetMapping(value = "http://localhost:8100/physicalspaces/type/{type}")
	public Page<PhysicalSpace> getByType(PhysicalSpaceType type, Pageable pageable);
	
	@GetMapping(value = "http://localhost:8100/physicalspaces/capacity/{capacity}")
	public Page<PhysicalSpace> getByCapacity(Integer capacity, Pageable pageable);
	
	@GetMapping(value = "http://localhost:8100/physicalspaces/name/{name}")
	public Page<PhysicalSpace> getByName(String name, Pageable pageable);
	
	@GetMapping(value = "http://localhost:8100/physicalspaces/availability/{availability}")
	public Page<PhysicalSpace> getByAvailability(Boolean availability, Pageable pageable);
}
