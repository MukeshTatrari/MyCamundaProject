package com.mukesh.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ReserveSeatOnCruiseError implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String bmi = "0.0";
        bmi = (String) delegateExecution.getVariable("bmiInfo");
        double bmiInfo = Double.parseDouble(bmi);

        if (bmiInfo >= 200) {
            throw new BpmnError("High_Blood_Pressure", "You have Very High BMI , Not recommended for Cruise Travel");
        }

        delegateExecution.setVariable("bmiInfo", bmi);
    }
}
