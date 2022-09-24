package com.mukesh.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class PaymentProcessor implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String mealType = (String) delegateExecution.getVariable("mealOptions");
        String totalMoney = (String) delegateExecution.getVariable("money");
        String payableAmount = "0.0";
        payableAmount = (String) delegateExecution.getVariable("mealAmount");
        double totalBill = Double.parseDouble(payableAmount);
        double tripMoney = Double.parseDouble(totalMoney);

        if(totalBill>tripMoney){
            throw new BpmnError("Payment_Failure", "You do not have enough Cash to Book the Meal..");
        }
        delegateExecution.setVariable("TotalBill", totalBill);


    }
}
