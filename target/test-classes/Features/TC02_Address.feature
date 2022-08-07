Feature: Address Module for API Automation

  @address
  Scenario Outline: User add the address from endpoints
    When User add headers for add address endpoint
    When User add the payload"<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>" for adding address
    And User send POST request for Addaddress Endpoint
    Then User verify the status code is 200 for adding address
    And User verify the address response body message "Address added succesfully" and save the address id

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address                   | address_type |
      | Raj        | sparrow   | 9884516467 | Carebean  |    33 | 3378 |     101 |  202020 | 3rd, waldormod, annanagar | work         |

  Scenario Outline: User update the address from endpoints
    When User add headers for update address endpoint
    When User add the payload "<firstname>","<lastname>","<mobileno>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<addresstype>" for updating the address with address_Id
    And user sent PUT request for Update endpoints
    Then User verify the status code is 200 for update address
    And User verify the update address response body message "Address updated succesfully"

    Examples: 
      | firstname | lastname | mobileno   | apartment | state | city | country | zipcode | address                   | addresstype |
      | captain   | sparrow  | 9884516467 | Carebean  |    33 | 3378 |     101 |  202020 | 3rd, waldormod, annanagar | work        |

  @delete
  Scenario: User delete the address from endpoints
    When User add headers foe delete address
    When User add the payload for deleting the address with address_Id
    And user sent DELETE request for delete endpoints
    Then User verify the status code is 200 for deleting address
    And User verify the delete address response body message "Address deleted succesfully"

  @get
  Scenario: User get the address from the endpoints
    When User add headers for get address
    When User send GET request for Getaddress Endpoint
    Then User verify the status code is 200 for get address
    And User verify the address response body message "Ok"
