package com.onerivet.model.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SeatConfiguration", schema="dbo")
public class SeatConfiguration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "SeatConfigurationId")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "EmployeeId")
	private Employee employee;

	@OneToOne
	@JoinColumn(name = "SeatNumberId")
	private Seat seatNumber;
	
	@OneToOne
	@JoinColumn(name = "ColumnId")
	private Columns columns;
	
	@OneToOne
	@JoinColumn(name = "FloorId")
	private Floor floor;
	
	@OneToOne
	@JoinColumn(name = "CityId")
	private City city;

}
