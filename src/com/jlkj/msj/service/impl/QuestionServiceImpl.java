package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.QuestionDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Question;
import com.jlkj.msj.service.QuestionService;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired(required = false)
    private QuestionDao questionDao;

    @Override
    public Result<Boolean> addQuestion(Question question,String userId) {
        question.setQuestionId(RandomUtil.getId());
        int resultNum = questionDao.addQuestion(question,userId);
        Result<Boolean> result;
        if(resultNum <= 0){
            result = new Result<>(false,false,Code.ADD_QUESTION_ERROR);
        }else {
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteQuestion(String questionId) {
        int resultNum = questionDao.deleteQuestion(questionId);
        Result<Boolean> result;
        if(resultNum <= 0){
            result = new Result<>(false,false, Code.DELETE_QUESTION_ERROR);
        }else{
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Question>> getQuestions(int page) {
        List<Question> questions = questionDao.getQuestions(new RowBounds(12*(page-1),12*page));
        Result<List<Question>> result;
        if(questions == null || questions.size() == 0){
            result = new Result<>(false,questions,Code.GET_QUESTION_ERROR);
        }else{
            result = new Result<>(true,questions,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Question>> getQuestionsByKeyWord(String key, int page) {
        List<Question> questions = questionDao.getQuestionsByKeyWord(key,new RowBounds(10*(page-1),10*page));
        Result<List<Question>> result;
        if(questions == null || questions.size() == 0){
            result = new Result<>(false,questions,Code.GET_QUESTION_ERROR);
        }else{
            result = new Result<>(true,questions,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Question>> getMyQuestions(String userId) {
        List<Question> questions = questionDao.getMyQuestions(userId);
        Result<List<Question>> result;
        if(questions == null || questions.size() == 0){
            result = new Result<>(false,questions,Code.GET_QUESTION_ERROR);
        }else{
            result = new Result<>(true,questions,Code.SUCCESS);
        }
        return result;
    }
}
