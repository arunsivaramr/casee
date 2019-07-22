Feature: Test TestMe App
	@register
	Scenario: Register 
    Given The browser is opened and URL is typed
    When I click on the SignUp button
    #Enter Username
		And I enter Username "arunsivaram"
		#Enter First Name and Last Name
		And I enter First Name "Arunsivaram" and Last Name "R"
		#Enter Password and confirm password
		And I enter Password "arun1234" and confirm password "arun1234"
		#Enter Male/Female
		And I enter Male/female "Male"
		#Enter Email and Mobile number
		And I enter Email "arunabcd@gmail.com" and Mobile number "9876543210"
		#Enter DOB in mm/dd/yyyy 
		And I enter DOB "04/07/1998"
		#Enter Address
		And I enter Address "51/85,Thiruvalluvar street,Srivaikundam"
		#Enter Security question from below
		#What is your Birth Place?
		#What is your favour color?
		#What is your Pet Name?
		#What is your Nick Name?
		And I Choose Security question "What is your Nick Name?" 
		#Enter answer
		And I enter the answer "abcde"
		#click Register button
		And I click on Register button
		

  @login
  Scenario Outline: Login
    Given The browser is opened and URL is typed
    When I click on the SignIn button
    And I enter the "<Username>" and "<password>"
    And I click on Login button
    Then Home page should be displayed

    Examples: 
      | Username		 | password    |
      | arunsivaram  | arun1234		 |

      
	@search
	Scenario: The one where user moves to cart without adding any item in it
	Given Alex has registered into TestMe App
	When Alex search a particular product like headphones
	And try to proceed to payment without adding any item in the cart
	Then TestmeApp doesn't display the cart icon
	Then click on add to cart button
	Then cart icon will be visible
	Then click on the cart icon