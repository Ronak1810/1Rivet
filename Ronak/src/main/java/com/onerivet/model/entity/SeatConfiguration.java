package com.onerivet.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[SeatConfiguration]", schema = "[dbo]")
public class SeatConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SeatConfigurationId")
	private int id;

	@OneToOne
	@JoinColumn(name = "SeatId")
	private Seat seatNumber;

	@OneToOne
	@JoinColumn(name = "CreatedBy")
	private Employee createdby;

	@Column(name = "CreatedDate")
	private LocalDateTime createdDate;

	@OneToOne
	@JoinColumn(name = "ModifiedBy")
	private Employee modifiedBy;

	@Column(name = "ModifiedDate")
	private LocalDateTime modifiedDate;

	@OneToOne
	@JoinColumn(name = "EmployeeId")
	private Employee employee;

	@OneToOne
	@JoinColumn(name = "DeletedBy")
	private Employee deletedBy;

	@JoinColumn(name = "DeletedDate")
	private LocalDateTime deletedDate;
}
