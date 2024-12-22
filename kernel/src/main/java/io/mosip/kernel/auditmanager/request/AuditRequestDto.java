package io.mosip.kernel.auditmanager.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.mosip.kernel.auditmanager.entity.Audit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Audit Request class with required fields to be captured and recorded
 * 
 * @author Dharmesh Khandelwal
 * @since 1.0.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditRequestDto {

	@NotNull
	@Size(min = 1, max = 64)
	private String eventId;

	@NotNull
	@Size(min = 1, max = 128)
	private String eventName;

	@NotNull
	@Size(min = 1, max = 64)
	private String eventType;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime actionTimeStamp;

	@NotNull
	@Size(min = 1, max = 128)
	private String hostName;

	@NotNull
	@Size(min = 1, max = 256)
	private String hostIp;

	@NotNull
	@Size(min = 1, max = 64)
	private String applicationId;

	@NotNull
	@Size(min = 1, max = 128)
	private String applicationName;

	@NotNull
	@Size(min = 1, max = 256)
	private String sessionUserId;

	@Size(min = 1, max = 128)
	private String sessionUserName;

	
	@Size(max = 64)
	private String id;
	
	
	@Size(max = 64)
	private String idType;

	@NotNull
	@Size(min = 1, max = 256)
	private String createdBy;

	@Size(max = 128)
	private String moduleName;

	@Size(max = 64)
	private String moduleId;

	@Size(max = 2048)
	private String description;

	public void validateAuditRequestDto() {
        StringBuilder errorMessages = new StringBuilder();

        // Validate each field manually
        if (this.getEventId() == null || this.getEventId().length() < 1 || this.getEventId().length() > 64) {
            errorMessages.append("eventId must be between 1 and 64 characters.\n");
        }
        if (this.getEventName() == null || this.getEventName().length() < 1 || this.getEventName().length() > 128) {
            errorMessages.append("eventName must be between 1 and 128 characters.\n");
        }
        if (this.getEventType() == null || this.getEventType().length() < 1 || this.getEventType().length() > 64) {
            errorMessages.append("eventType must be between 1 and 64 characters.\n");
        }
        if (this.getActionTimeStamp() == null) {
            errorMessages.append("actionTimeStamp must not be null.\n");
        }
        if (this.getHostName() == null || this.getHostName().length() < 1 || this.getHostName().length() > 128) {
            errorMessages.append("hostName must be between 1 and 128 characters.\n");
        }
        if (this.getHostIp() == null || this.getHostIp().length() < 1 || this.getHostIp().length() > 256) {
            errorMessages.append("hostIp must be between 1 and 256 characters.\n");
        }
        if (this.getApplicationId() == null || this.getApplicationId().length() < 1 || this.getApplicationId().length() > 64) {
            errorMessages.append("applicationId must be between 1 and 64 characters.\n");
        }
        if (this.getApplicationName() == null || this.getApplicationName().length() < 1 || this.getApplicationName().length() > 128) {
            errorMessages.append("applicationName must be between 1 and 128 characters.\n");
        }
        if (this.getSessionUserId() == null || this.getSessionUserId().length() < 1 || this.getSessionUserId().length() > 256) {
            errorMessages.append("sessionUserId must be between 1 and 256 characters.\n");
        }
        if (this.getCreatedBy() == null || this.getCreatedBy().length() < 1 || this.getCreatedBy().length() > 256) {
            errorMessages.append("createdBy must be between 1 and 256 characters.\n");
        }
        if (this.getSessionUserName() != null && this.getSessionUserName().length() > 128) {
            errorMessages.append("sessionUserName must not exceed 128 characters.\n");
        }
        if (this.getId() != null && this.getId().length() > 64) {
            errorMessages.append("id must not exceed 64 characters.\n");
        }
        if (this.getIdType() != null && this.getIdType().length() > 64) {
            errorMessages.append("idType must not exceed 64 characters.\n");
        }
        if (this.getModuleName() != null && this.getModuleName().length() > 128) {
            errorMessages.append("moduleName must not exceed 128 characters.\n");
        }
        if (this.getModuleId() != null && this.getModuleId().length() > 64) {
            errorMessages.append("moduleId must not exceed 64 characters.\n");
        }
        if (this.getDescription() != null && this.getDescription().length() > 2048) {
            errorMessages.append("description must not exceed 2048 characters.\n");
        }

        // Throw exception if there are validation errors
        if (errorMessages.length() > 0) {
            throw new IllegalArgumentException(errorMessages.toString());
        }
    }

	public Audit getAuditEntity() {
		Audit audit = new Audit();
        audit.setEventId(this.getEventId());
        audit.setEventName(this.getEventName());
        audit.setEventType(this.getEventType());
        audit.setActionTimeStamp(this.getActionTimeStamp());
        audit.setHostName(this.getHostName());
        audit.setHostIp(this.getHostIp());
        audit.setApplicationId(this.getApplicationId());
        audit.setApplicationName(this.getApplicationName());
        audit.setSessionUserId(this.getSessionUserId());
        audit.setSessionUserName(this.getSessionUserName());
        audit.setId(this.getId());
        audit.setIdType(this.getIdType());
        audit.setCreatedBy(this.getCreatedBy());
        audit.setModuleName(this.getModuleName());
        audit.setModuleId(this.getModuleId());
        audit.setDescription(this.getDescription());
        
        return audit;
    }
}
