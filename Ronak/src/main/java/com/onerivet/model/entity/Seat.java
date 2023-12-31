package com.onerivet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[Seat]", schema = "[Ref]")
public class Seat {
	
	@Id
	@Column(name = "SeatId")
	private int id;
	
	@Column(name = "SeatNumber")
	private int seatNumber;
	
	@OneToOne
	@JoinColumn(name = "ColumnId")
	private ColumnDetails columnDetails;
	
	@Transient
	private boolean booked;

}
