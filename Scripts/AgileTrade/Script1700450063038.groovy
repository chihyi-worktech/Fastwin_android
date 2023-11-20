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

Mobile.startExistingApplication(GlobalVariable.applicationID)

Mobile.tap(findTestObject('BottomNavigation/quotation'), 0)

Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/trade_Quotation'), 0)

Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/quotation_Forex'), 0)

if(Mobile.waitForElementPresent(findTestObject('Object Repository/Quotation/AgileTrade/EURUSD_UIAutomator'), 3)) {
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/EURUSD_UIAutomator'),3)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/agileTrade_Long'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/lotSize_First'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/BuyLong'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/checkPosition'), 0)
	
	
}

else if(Mobile.waitForElementPresent(findTestObject('Object Repository/Quotation/AgileTrade/EURUSD_XPATH'), 3)){
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/EURUSD_XPATH'),3)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/agileTrade_Long'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/lotSize_First'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/BuyLong'), 0)
	
	Mobile.tap(findTestObject('Object Repository/Quotation/AgileTrade/checkPosition'), 0)
	
}

else {
	System.out.println("EURUSD do not exist in DOM anymore");
}
