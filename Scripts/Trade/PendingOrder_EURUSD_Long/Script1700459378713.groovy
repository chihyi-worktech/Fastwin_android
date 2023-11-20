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

//Mobile.startExistingApplication(GlobalVariable.applicationID)

Mobile.tap(findTestObject('Object Repository/BottomNavigation/trade'),0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/trade_PendingOrder'), 0)

'關閉首進提示'
if(Mobile.waitForElementPresent(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Skip'), 3)) {
	
	Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Skip'), 0)
	
}

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Menu'), 0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/EURUSD'), 0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Long'), 0)

Mobile.setText(findTestObject('Object Repository/Trade/PendingOrder/price'), '1.2', 0)

Mobile.setText(findTestObject('Object Repository/Trade/PendingOrder/lotsize'), '0.01', 0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Confirm'), 0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder/pendingOrder_Check'), 0)

