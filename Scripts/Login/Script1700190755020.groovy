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

Mobile.startExistingApplication('vscdjr.ngycbz.qzetja.wosztw')

WebUI.callTestCase(findTestCase('FirstEnterPage/CloseActicity'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('BottomNavigation/home'), 0)

'判斷是否已登錄'
if (Mobile.waitForElementPresent(findTestObject('Object Repository/Login/home_Login'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Login/home_Login'), 0)
} else {
    WebUI.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('BottomNavigation/home'), 0)

    Mobile.tap(findTestObject('Object Repository/Login/home_Login'), 0)
}

'輸入MT4帳號'
Mobile.setText(findTestObject('Object Repository/Login/MT4ccount'), GlobalVariable.MT4Account, 0)

'輸入密碼'
Mobile.setText(findTestObject('Object Repository/Login/password'), GlobalVariable.password, 0)

'點擊登錄'
Mobile.tap(findTestObject('Object Repository/Login/login'), 0)

'關閉首次登錄提示'
if (Mobile.waitForElementPresent(findTestObject('Object Repository/Login/firstLogin'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Login/firstLogin'), 0)
}

