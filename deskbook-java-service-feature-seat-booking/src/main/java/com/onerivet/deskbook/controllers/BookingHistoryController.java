package com.onerivet.deskbook.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.models.payload.BookingHistoryDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.BookingHistoryService;
import com.onerivet.deskbook.util.PaginationAndSorting;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.mail.MessagingException;

@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookingHistoryService;
    
    

    public BookingHistoryController(BookingHistoryService bookingHistoryService) {
		super();
		this.bookingHistoryService = bookingHistoryService;
	}

    /**
     * @purpose get all booking history, get booking history by request status 
     * @param principal
     * @param pagination
     * @param requestStatus
     * @return List of booking history 
     */
	@GetMapping(value = {"/booking-history/{requestStatus}","/booking-history/"})
    public GenericResponse<List<BookingHistoryDto>> getBookingHistoryByStatus(Principal principal,
            PaginationAndSorting pagination, @PathVariable(required = false) Integer requestStatus) {

        GenericResponse<List<BookingHistoryDto>> genericResponse = new GenericResponse<>(this.bookingHistoryService
                .getBookingRequest(principal.getName(), pagination.createPageRequest(), requestStatus), null);

        return genericResponse;

    }
	
	/**
	 * @purpose cancel request
	 * @param principal
	 * @param requestId
	 * @return String : canccel sucessfully
	 * @throws MessagingException
	 */
    @PutMapping("/cancel-request/{requestId}")
    public GenericResponse<String> cancelBooking( Principal principal, @PathVariable int requestId) throws MessagingException {
        GenericResponse<String> genericResponse = new GenericResponse<>(
                this.bookingHistoryService.cancelBooking(principal.getName(), requestId), null);
        
        return genericResponse;
        
    }
}