package models;

import java.math.BigDecimal;

public class Sale {
	private Long operationId;
	private Long client;
	private Integer quantity;
	private BigDecimal totalValue;
	private String status;
	
	public Sale(Long operationId, Long client, Integer quantity, BigDecimal totalValue) {
		super();
		this.operationId = operationId;
		this.client = client;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}

	public Long getOperationId() {
		return operationId;
	}

	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
