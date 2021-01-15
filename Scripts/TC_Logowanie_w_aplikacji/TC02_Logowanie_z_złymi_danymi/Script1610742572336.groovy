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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(rawUri=GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Home/btn_signIn'))

for (def row = 1; row <= 2; row++)
{
	WebUI.setText(findTestObject('PageSignUp/input_email'),
		 findTestData('Data Files/conduit/LoginData').getValue('email', row))
	WebUI.setText(findTestObject('PageSignUp/input_password'), 
		findTestData('Data Files/conduit/LoginData').getValue('password', row))

	WebUI.click(findTestObject('Object Repository/PageSignIn/btn_signUp_form'))

	String msg_error = WebUI.getText(findTestObject('Object Repository/PageSignIn/p_error-messages'))
	assert login_error_text == msg_error
}

WebUI.closeBrowser()