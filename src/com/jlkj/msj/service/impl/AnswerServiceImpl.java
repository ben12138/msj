package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.AnswerDao;
import com.jlkj.msj.dao.PraiseDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Answer;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Praise;
import com.jlkj.msj.entity.Type;
import com.jlkj.msj.service.AnswerService;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired(required = false)
    private AnswerDao answerDao;
    @Autowired(required = false)
    private PraiseDao praiseDao;

    @Override
    public Result<Answer> addAnswer(Answer answer, String userId) {
        answer.setAnswerId(RandomUtil.getId());
        int answerResultNum = answerDao.addAnswer(answer,userId);
        Result<Answer> result;
        if(answerResultNum <= 0){
            result = new Result<>(false,answer, Code.ADD_ANSWER_ERROR);
        }else {
            result = new Result<>(true,answer,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteAnswer(String answerId) {
        int deleteResultNum = answerDao.deleteAnswer(answerId);
        Result<Boolean> result;
        if(deleteResultNum <= 0){
            result = new Result<>(false,false,Code.DELETE_ANSWER_ERROR);
        }else {
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Answer>> getAnswers(Answer answer, int page) {
        List<Answer> answers = answerDao.getAnswers(answer,new RowBounds(10*(page-1),10*page));
        for(Answer temp:answers){
            List<Praise> praises = praiseDao.getPraises(temp.getAnswerId(), Type.ANSWER);
            temp.setPraises(praises);
        }
        Result<List<Answer>> result;
        if(answers == null || answers.size() == 0){
            result = new Result<>(false,answers,Code.GET_ANSWER_ERROR);
        }else {
            result = new Result<>(true,answers,Code.SUCCESS);
        }
        return result;
    }
}
