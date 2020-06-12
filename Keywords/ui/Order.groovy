package ui

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class Order {

	@Keyword
	def onProcess(String cardNo, String exp, String cvv){

		KeywordUtil.logInfo("Swipe Horizontal page2")
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()

		KeywordUtil.logInfo("Wait for load page")
		WebUI.waitForElementPresent(findTestObject('/Home/text_MidtransPillow'), 60)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Click button Buy Now")
		WebUI.click(findTestObject('/Home/button_BuyNow'))
		WebUI.waitForElementPresent(findTestObject('/ShoppingCart/text_ShoppingCart'), 10)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Click button Check Out")
		WebUI.click(findTestObject('/ShoppingCart/button_CheckOut'))
		WebUI.waitForElementPresent(findTestObject('/OrderSummary/text_CocoStore'), 10)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Click button Continue")
		WebUI.delay(1)
		WebUI.click(findTestObject('/OrderSummary/button_Continue'))
		WebUI.waitForElementPresent(findTestObject('/PaymentList/CreditCard'), 10)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Click Credit Card")
		WebUI.click(findTestObject('/PaymentList/CreditCard'))
		WebUI.waitForElementPresent(findTestObject('/InputCC/button_PayNow'), 10)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Input Card Number")
		WebUI.setText(findTestObject('/InputCC/input_CardNumber'),
				cardNo)

		KeywordUtil.logInfo("Input Expiry Date")
		WebUI.setText(findTestObject('/InputCC/input_ExpiryDate'),
				exp)

		KeywordUtil.logInfo("Input CVV")
		WebUI.setText(findTestObject('/InputCC/input_CVV'),
				cvv)
		WebUI.takeScreenshot()

		KeywordUtil.logInfo("Click button Paynow")
		WebUI.click(findTestObject('/InputCC/button_PayNow'))
		if(cardNo=="4811111111111114"){
			WebUI.delay(10)
			//WebUI.waitForElementPresent(findTestObject('/Confirm/text_Issuing'), 30)
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("Input OTP")
			WebUI.setText(findTestObject('/Confirm/input_OTP'), "112233")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("Click button Ok")
			WebUI.click(findTestObject('/Confirm/button_OK'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/SuccessMessage/Message_TransactionSuccessful'), 30)
			WebUI.takeScreenshot()

			WebUI.delay(2)

			KeywordUtil.logInfo("Move to Home Page")
			WebUI.waitForElementPresent(findTestObject('/Home/text_ThankYou_Purchase'), 120)
			WebUI.takeScreenshot()
		}else{

			//WebUI.waitForElementPresent(findTestObject('/Confirmation/text_IssuingBank'), 30)
			WebUI.delay(10)
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("Input OTP")
			WebUI.setText(findTestObject('/Confirmation/input_OTP'), "112233")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("Click button Ok")
			WebUI.click(findTestObject('/Confirmation/button_OK'))
			WebUI.waitForElementPresent(findTestObject('/FailedMessage/text_Transactionfailed'), 30)
			WebUI.takeScreenshot()


		}
	}
}
