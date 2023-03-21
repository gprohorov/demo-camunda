package com.example.workflow;
/*
  @author   george
  @project   camunda-demo
  @class  Greeting
  @version  1.0.0 
  @since 21.03.23 - 23.13
*/

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Greeting implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String greeting = "Hi!";
        int oClock = (int) delegateExecution.getVariable("oclock");
       boolean isMorning = (oClock >= 6 && oClock <= 11);

       if(isMorning) {
           greeting = "Good morning!";
       } else {
           greeting = "Hello!";
       }
      //  delegateExecution.setVariable("oclock", oClock);
        delegateExecution.setVariable("isMorning", isMorning);
    }
}
