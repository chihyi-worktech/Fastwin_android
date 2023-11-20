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
Mobile.tap(findTestObject('Object Repository/BottomNavigation/mine'), 0)

WebUI.callTestCase(findTestCase('FirstEnterPage/CloseCSInfo'), [:], FailureHandling.STOP_ON_FAILURE)

'點擊出金'
Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/mine_Withdraw'), 0)

String amount = '5'

'設定出金金額'
Mobile.setText(findTestObject('Object Repository/Mine/Withdraw/withdrawAmount'), amount, 0)

String message

if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/amountLimit'), 3)) {
    message = Mobile.getText(findTestObject('Object Repository/Mine/Withdraw/amountLimit'), 0)

    System.out.println('未提交出金申請，原因：' + message)

    Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/backtoMine'), 0) //提交出金申請失敗
} else {
    '點擊提交'
    Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/withdraw_Submit'), 0)

    '低於50美金提示訊息'
    if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/lower50USDMessage'), 3)) {
        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/lower50USDMessage'), 0)

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/withdraw_Submit'), 0)
    }
    
    '提交出金申請'
    if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/withdraw_Success'), 3)) {
        System.out.println('提交出金申請成功')

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/checkSuccessMessage'), 0)

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/cashflow_CancelWithdraw'), 0)

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/cashFlow_BacktoMine'), 0)
    } else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/withdraw_Fail'), 3)) {
        message = Mobile.getText(findTestObject('Object Repository/Mine/Withdraw/withdraw_FailMessage'), 0)

        System.out.println('出金申請失敗，失敗原因：' + message)

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/closeFailMessage'), 0)

        Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/backtoMine'), 0)
    } else {
        System.out.println('提交出金申請失敗')
    }
}

