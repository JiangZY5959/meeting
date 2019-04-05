package com.caztc.domain;

public class MeetingRoom {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_id
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    private Integer meetingroomId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_name
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    private String meetingroomName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_size
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    private Integer meetingroomSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_note
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    private String meetingroomNote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_state
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    private String meetingroomState;
    private String meetingRoomUseState;

    public String getMeetingRoomUseState() {
        return meetingRoomUseState;
    }

    public void setMeetingRoomUseState(String meetingRoomUseState) {
        this.meetingRoomUseState = meetingRoomUseState;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    private String equipmentName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_id
     *
     * @return the value of meeting_room.meetingroom_id
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public Integer getMeetingroomId() {
        return meetingroomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_id
     *
     * @param meetingroomId the value for meeting_room.meetingroom_id
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public void setMeetingroomId(Integer meetingroomId) {
        this.meetingroomId = meetingroomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_name
     *
     * @return the value of meeting_room.meetingroom_name
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public String getMeetingroomName() {
        return meetingroomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_name
     *
     * @param meetingroomName the value for meeting_room.meetingroom_name
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public void setMeetingroomName(String meetingroomName) {
        this.meetingroomName = meetingroomName;
    }

    public Integer getMeetingroomSize() {
        return meetingroomSize;
    }

    public void setMeetingroomSize(Integer meetingroomSize) {
        this.meetingroomSize = meetingroomSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_note
     *
     * @return the value of meeting_room.meetingroom_note
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public String getMeetingroomNote() {
        return meetingroomNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_note
     *
     * @param meetingroomNote the value for meeting_room.meetingroom_note
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public void setMeetingroomNote(String meetingroomNote) {
        this.meetingroomNote = meetingroomNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_state
     *
     * @return the value of meeting_room.meetingroom_state
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public String getMeetingroomState() {
        return meetingroomState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_state
     *
     * @param meetingroomState the value for meeting_room.meetingroom_state
     *
     * @mbggenerated  Wed March 21 13:51:45 CST 2019
     */
    public void setMeetingroomState(String meetingroomState) {
        this.meetingroomState = meetingroomState;
    }

	@Override
	public String toString() {
		return "MeetingRoom [meetingroomId=" + meetingroomId
				+ ", meetingroomName=" + meetingroomName + ", meetingroomSize="
				+ meetingroomSize + ", meetingroomNote=" + meetingroomNote
				+ ", meetingroomState=" + meetingroomState + "]";
	}
    
    
    
}