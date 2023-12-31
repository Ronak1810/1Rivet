package com.onerivet.deskbook.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onerivet.deskbook.exception.ResourceNotFoundException;
import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatConfiguration;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.models.payload.RequestHistoryTakeActionDto;
import com.onerivet.deskbook.repository.EmployeeRepo;
import com.onerivet.deskbook.repository.SeatConfigurationRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;
import com.onerivet.deskbook.services.RequestHistoryService;

@Transactional
@Service
public class RequestHistoryServiceImpl implements RequestHistoryService {

	@Autowired
	private SeatRequestRepo seatRequestRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private SeatConfigurationRepo seatConfigurationRepo;

	public RequestHistoryServiceImpl(SeatRequestRepo seatRequestRepo, SeatConfigurationRepo seatConfigurationRepo) {
		super();
		this.seatRequestRepo = seatRequestRepo;
		this.seatConfigurationRepo = seatConfigurationRepo;
	}

	@Override
	public List<RequestHistoryDto> getRequestHistory(String employeeId, Pageable pageble, Integer requestStatus) {

		Employee employee = employeeRepo.findById(employeeId).get();
		if (employee.getModeOfWork().getId() == 2) {

			Collections.emptyList();
		}

		SeatConfiguration seatConfiguration = seatConfigurationRepo
				.findByEmployeeAndDeletedByNull(new Employee(employeeId));

		if (requestStatus == null) {// call for all
			List<SeatRequest> seatRequest = this.seatRequestRepo
					.findSeatRequestBySeat(new SeatNumber(seatConfiguration.getSeatNumber().getId()), pageble);

			List<RequestHistoryDto> list = new ArrayList<>();
			for (int i = 0; i < seatRequest.size(); i++) {

				RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
				requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
						+ seatRequest.get(i).getEmployee().getLastName());
				requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
						+ seatRequest.get(i).getSeat().getSeatNumber());
				requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
				requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
				requestHistoryDto.setSeatRequestId(seatRequest.get(i).getId());
				requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
				requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
				requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());
				requestHistoryDto.setReason(seatRequest.get(i).getReason());
				list.add(requestHistoryDto);
			}
			return list;
		}

		List<SeatRequest> seatRequest = this.seatRequestRepo.findSeatRequestBySeatAndRequestStatus(
				new SeatNumber(seatConfiguration.getSeatNumber().getId()), pageble, requestStatus);

		List<RequestHistoryDto> list = new ArrayList<>();
		for (int i = 0; i < seatRequest.size(); i++) {

			RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
			requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
					+ seatRequest.get(i).getEmployee().getLastName());
			requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
					+ seatRequest.get(i).getSeat().getSeatNumber());
			requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
			requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
			requestHistoryDto.setSeatRequestId(seatRequest.get(i).getId());
			requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
			requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
			requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());
			requestHistoryDto.setReason(seatRequest.get(i).getReason());
			list.add(requestHistoryDto);
		}
		return list;
	}

	@Override
	public List<RequestHistoryDto> searchByFirstNameOrLastName(String name, Pageable pageable) {
		if (name.length() < 2) {

			throw new IllegalArgumentException("Please enter at least two characters.");
		}

		List<SeatRequest> seatRequest = this.seatRequestRepo.getByFirstNameOrLastName(name, name, pageable);

		if (seatRequest.isEmpty()) {
			throw new ResourceNotFoundException("Resource not found.");
		}

		List<RequestHistoryDto> list = new ArrayList<>();
		for (int i = 0; i < seatRequest.size(); i++) {

			RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
			requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
					+ seatRequest.get(i).getEmployee().getLastName());
			requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
					+ seatRequest.get(i).getSeat().getSeatNumber());
			requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
			requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
			requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
			requestHistoryDto.setSeatRequestId(seatRequest.get(i).getId());
			requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
			requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());

			list.add(requestHistoryDto);
		}
		return list;
	}

//	@Override
//	public RequestHistoryTakeActionDto takeAction(RequestHistoryDto dto) {
//		
//		
//		RequestHistoryTakeActionDto historyDto=new RequestHistoryTakeActionDto();
//		SeatRequest request=seatRequestRepo.findById(dto.getSeatRequestId()).get();
//		
//		String reason=request.getReason();
//		historyDto.setEmployeeId(request.getEmployee().getId());
//		historyDto.setDeskNo(dto.getDeskNo());
//		historyDto.setEmailId(dto.getEmailId());
//		historyDto.setFloorNo(dto.getFloorNo());
//		historyDto.setName(dto.getName());
//		historyDto.setReason(reason);
//		historyDto.setRequestDate(dto.getRequestDate());
//		historyDto.setRequestFor(dto.getRequestFor());
//		historyDto.setSeatRequestId(dto.getSeatRequestId());
//		historyDto.setStatus(dto.getStatus());
//		
//		
//		
//		return historyDto;
//	}
}