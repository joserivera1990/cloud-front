package com.viagging.rest.dto;

public class VariabilidadDTO {
    
	private boolean hasReport;
	
	private boolean hasMessage;
	
	private boolean hasComments;
	
	private boolean hasWeather;
	
	private boolean hasFacebook;
	
	private boolean hasTwitter;
	
	private boolean hasPublishFacebook;
	
	private boolean hasPublishTwitter;
	
	public VariabilidadDTO(boolean hasReport, boolean hasMessage,
			boolean hasComments, boolean hasWeather, boolean hasFacebook,
			boolean hasTwitter, boolean hasPublishFacebook, boolean hasPublishTwitter) {
		super();
		this.hasReport = hasReport;
		this.hasMessage = hasMessage;
		this.hasComments = hasComments;
		this.hasWeather = hasWeather;
		this.hasFacebook = hasFacebook;
		this.hasTwitter = hasTwitter;
		this.hasPublishFacebook = hasPublishFacebook;
		this.hasPublishTwitter = hasPublishTwitter;
	}

	public boolean isHasFacebook() {
		return hasFacebook;
	}

	public void setHasFacebook(boolean hasFacebook) {
		this.hasFacebook = hasFacebook;
	}

	public boolean isHasTwitter() {
		return hasTwitter;
	}

	public void setHasTwitter(boolean hasTwitter) {
		this.hasTwitter = hasTwitter;
	}

	public boolean isHasReport() {
		return hasReport;
	}

	public void setHasReport(boolean hasReport) {
		this.hasReport = hasReport;
	}

	public boolean isHasMessage() {
		return hasMessage;
	}

	public void setHasMessage(boolean hasMessage) {
		this.hasMessage = hasMessage;
	}

	public boolean isHasComments() {
		return hasComments;
	}

	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}

	public boolean isHasWeather() {
		return hasWeather;
	}

	public void setHasWeather(boolean hasWeather) {
		this.hasWeather = hasWeather;
	}

	public boolean isHasPublishFacebook() {
		return hasPublishFacebook;
	}

	public void setHasPublishFacebook(boolean hasPublishFacebook) {
		this.hasPublishFacebook = hasPublishFacebook;
	}

	public boolean isHasPublishTwitter() {
		return hasPublishTwitter;
	}

	public void setHasPublishTwitter(boolean hasPublishTwitter) {
		this.hasPublishTwitter = hasPublishTwitter;
	}
	
}
