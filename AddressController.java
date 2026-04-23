package com.ms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Address;
import com.ms.request.CreateAddressRequest;
import com.ms.response.AddressResponse;
import com.ms.service.AddressService;



@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;


	@PostMapping("/create")
	public AddressResponse  createAddress(@RequestBody CreateAddressRequest createaddressreq)
	{
		return addressService.createAddress(createaddressreq);
	}
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<Address> getAll() {
		return addressService.getAllAddress();
	}
	/*
	 * @GetMapping("/getallcity") public List<String> getAllCity() { return
	 * addressService.getAllCity(); }
	 */
	
	@GetMapping("/getcity/{id}")
	public List<Address>  getByName(@PathVariable String id) {
		return addressService.findByCity(id);
	}
	
	@PostMapping("/create1")
	public Address   createNewAddress(@RequestBody CreateAddressRequest createaddressreq)
	{
		return addressService.createNewAddress(  createaddressreq);
	}
}