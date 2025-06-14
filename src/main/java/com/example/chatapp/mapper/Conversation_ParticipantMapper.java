package com.example.chatapp.mapper;

import com.example.chatapp.model.Conversation_ParticipantExample;
import com.example.chatapp.model.Conversation_ParticipantKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Conversation_ParticipantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    long countByExample(Conversation_ParticipantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int deleteByExample(Conversation_ParticipantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int deleteByPrimaryKey(Conversation_ParticipantKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    
    void insertConversationParticipants(Map<String, Object> map);
    
    int insert(Conversation_ParticipantKey row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int insertSelective(Conversation_ParticipantKey row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    List<Conversation_ParticipantKey> selectByExample(Conversation_ParticipantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    
    List<String> getUserIdsByConversationId(@Param("conversationId") String conversationId);
    
    int updateByExampleSelective(@Param("row") Conversation_ParticipantKey row, @Param("example") Conversation_ParticipantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation_participant
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int updateByExample(@Param("row") Conversation_ParticipantKey row, @Param("example") Conversation_ParticipantExample example);
}