Feature: To Automate The Website

  Scenario: Automating The Website USing Browser Commands
    * configure driver = { type: 'chromedriver' , executable: 'C:\\\\drivers\\\\chromedriver.exe' }
    Given driver "https://www.saucedemo.com/"
    And driver.maximize()
    Then match driver.url == "https://www.saucedemo.com/"
    Then match driver.title == "Swag Labs"
    And waitFor( "#user-name" )
    * delay(2000)
    And input( "#user-name" , "standard_user" )
    And waitFor( "#password" )
    And input( "#password" , "secret_sauce" )
    And click( "//input[@name='login-button']" )
    * delay(2000)
    * screenshot( "//div[@id='inventory_container']" )
    * delay(2000)
    And waitFor( "{}Sauce Labs Backpack" )
    * delay(2000)
    And click( "{}Sauce Labs Backpack" )
    * delay(2000)
    And click( "{}Add to cart" )
