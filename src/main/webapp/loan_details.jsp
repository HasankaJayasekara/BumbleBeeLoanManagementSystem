<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Loan Details</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#repaymentPeriod').change(function() {
				var loanAmount = parseInt($('#loanAmount').text());
				var repaymentPeriod = parseInt($(this).val());
				var interestRate = 10; // 10% interest rate
				var totalAmount = loanAmount + (loanAmount * interestRate / 100);
				var monthlyInstallment = totalAmount / repaymentPeriod;
				$('#totalAmount').text(totalAmount.toFixed(2));
				$('#monthlyInstallment').text(monthlyInstallment.toFixed(2));
			});
		});
	</script>
</head>
<body>
	<h1>Loan Details</h1>
	<p>Your loan has been approved. The details are as follows:</p>
	<ul>
		<li>Loan Amount: $<span id="loanAmount">${loanAmount}</span></li>
		<li>Interest Rate: 10%</li>
		<li>Repayment Period: <span id="repaymentPeriod">${repaymentPeriod}</span> months</li>
		<li>Total Amount: $<span id="totalAmount"></span></li>
		<li>Monthly Installment: $<span id="monthlyInstallment"></span></li>
	</ul>
	<p>Please select your repayment period:</p>
	<select id="repaymentPeriod" name="repaymentPeriod">
		<option value="3" ${repaymentPeriod == 3 ? 'selected' : ''}>3 months</option>
		<option value="6" ${repaymentPeriod == 6 ? 'selected' : ''}>6 months</option>
		<option value="9" ${repaymentPeriod == 9 ? 'selected' : ''}>9 months</option>
		<option value="12" ${repaymentPeriod == 12 ? 'selected' : ''}>12 months</option>
	</select>
</body>
</html>
