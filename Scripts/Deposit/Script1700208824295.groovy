import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('BottomNavigation/mine'), 0)

WebUI.callTestCase(findTestCase('FirstEnterPage/CloseCSInfo'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Mine/Deposit/deposit'), 0)

String amount;

if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/channelE_text'), 3)) {
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/channelE'), 0)
	'設定最小入金金額'
	amount="100";
	Mobile.setText(findTestObject('Object Repository/Mine/Deposit/depositAmount'), amount, 0)
	'提交入金申請'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/checkDeposit'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/second_CheckDeposit'), 0)
	'入金頁點擊確認'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/webview_Check'), 0)
	System.out.println("使用渠道E提交入金申請");
	'回到我的頁面'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/webview_Back'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/backtoMine'), 0)
}

else if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/channelA_text'), 3)) {
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/channelA'), 0)
	'設定最小入金金額'
	amount="150";
	Mobile.setText(findTestObject('Object Repository/Mine/Deposit/depositAmount'), amount, 0)
	'提交入金申請'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/checkDeposit'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/second_CheckDeposit'), 0)
	'入金頁點擊確認'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/webview_Check'), 0)
	System.out.println("使用渠道E提交入金申請");
	'回到我的頁面'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/webview_Back'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/backtoMine'), 0)
}

else if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/SITPaymentText'), 3)) {
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/SITChannel'), 0)
	'設定最小入金金額'
	amount="100";
	Mobile.setText(findTestObject('Object Repository/Mine/Deposit/depositAmount'), amount, 0)
	'提交入金申請'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/checkDeposit'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/second_CheckDeposit'), 0)
	'點擊支付成功'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/SITPayment_Success'),0)
	System.out.println("使用測試支付(SIT渠道)提交入金申請");
	'回到我的頁面'
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/webview_Back'), 0)
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/backtoMine'), 0)
}

else {
	System.out.println("無可以提交入金申請的渠道");
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/backtoMine'), 0)
}