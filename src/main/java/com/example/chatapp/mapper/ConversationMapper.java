package com.example.chatapp.mapper;

import com.example.chatapp.model.Conversation;
import com.example.chatapp.model.ConversationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConversationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    long countByExample(ConversationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int deleteByExample(ConversationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int insert(Conversation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int insertSelective(Conversation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    List<Conversation> selectByExample(ConversationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    
    List<Conversation> getConversationsByUserId(@Param("userId") String userId);
    
    Conversation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int updateByExampleSelective(@Param("row") Conversation row, @Param("example") ConversationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int updateByExample(@Param("row") Conversation row, @Param("example") ConversationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int updateByPrimaryKeySelective(Conversation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table conversation
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    int updateByPrimaryKey(Conversation row);
}