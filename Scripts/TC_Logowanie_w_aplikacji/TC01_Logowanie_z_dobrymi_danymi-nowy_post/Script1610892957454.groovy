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



for (def row = 3; row <= findTestData('Data Files/conduit/LoginData').getRowNumbers(); row++)
{
	WebUI.click(findTestObject('Home/btn_signIn'))
	WebUI.setText(findTestObject('PageSignUp/input_email'),
		 findTestData('Data Files/conduit/LoginData').getValue('email', row))
	WebUI.setText(findTestObject('PageSignUp/input_password'), 
		findTestData('Data Files/conduit/LoginData').getValue('password', row))

	WebUI.click(findTestObject('Object Repository/PageSignIn/btn_signUp_form'))

	String new_post_button_text = WebUI.getText(findTestObject('Home-LoggedIn/btn_newPost'))
	assert new_post_anchor == new_post_button_text
	
	WebUI.click(findTestObject('Object Repository/Home-LoggedIn/btn_newPost'))
	WebUI.setText(findTestObject('Object Repository/PageNewPost/input_articleTitle'), GlobalVariable.articleTitle)
	WebUI.setText(findTestObject('Object Repository/PageNewPost/input_articleAbout'), GlobalVariable.articleAbout)
	WebUI.setText(findTestObject('Object Repository/PageNewPost/input_articleBody'), GlobalVariable.articleBody)
	WebUI.setText(findTestObject('Object Repository/PageNewPost/input_articleTags'), GlobalVariable.articleTags)
	
	WebUI.click(findTestObject('Object Repository/PageNewPost/btn_publishArticle'))
	
	String delete_btn_innerHTML = WebUI.getText(findTestObject('Object Repository/PageEditPost-Author/btn_deleteArticle'))
	assert delete_btn_msg == delete_btn_innerHTML
	
	WebUI.click(findTestObject('Object Repository/Home-LoggedIn/btn_signOut'))
}

WebUI.closeBrowser()