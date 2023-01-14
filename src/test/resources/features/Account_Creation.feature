@AccountCreation
Feature: New Account Creation

  Background: 
    Given Admin has already logged into the application

  @AccountCreation-Advertiser
  Scenario: Advertiser Account Creation
    When User creates new account for "Advertiser" Record type
      | Element Name                                      | Values                      |
      | NewAccount.AccountName                            | Test_Advertiser_{TimeStamp} |
      | Account Record Sub Type.SingleInputDropdown       | Advertiser                  |
      | No Website.Checkbox                               | Y                           |
      | Billing City.TextBox                              | Burlington                  |
      | Billing Zip/Postal Code.TextBox                   |                       27215 |
      | Billing State/Province.SingleInputDropdown        | North Carolina              |
      | Billing Street.TextBox                            | 786 Boone Station Drive     |
      | Copy Billing Address to Shipping Address.Checkbox | Y                           |
      | Credit Status.SingleInputDropdown                 | Cash with Order             |
    Then user deletes the "Advertiser" record type

  @AccountCreation-Agency
  Scenario: Agency Account Creation
    When User creates new account for "Agency" Record type
      | Element Name                                      | Values                      |
      | NewAccount.AccountName                            | Test_Advertiser_{TimeStamp} |
      | Account Record Sub Type.SingleInputDropdown       | Agency                      |
      | No Website.Checkbox                               | Y                           |
      | Billing City.TextBox                              | Burlington                  |
      | Billing Zip/Postal Code.TextBox                   |                       27215 |
      | Billing State/Province.SingleInputDropdown        | North Carolina              |
      | Billing Street.TextBox                            | 786 Boone Station Drive     |
      | Copy Billing Address to Shipping Address.Checkbox | Y                           |
      | Credit Status.SingleInputDropdown                 | Cash with Order             |
      | Oracle Credit Hold.SingleInputDropdown            | Y                           |
      | Account Approval Status.SingleInputDropdown       | Prospect                    |
    Then user deletes the "Agency" record type

  @AccountCreation-Brand
  Scenario: Brand Account Creation
    When User creates new account for "Brand" Record type
      | Element Name                                | Values                      |
      | NewAccount.AccountName                      | Test_Advertiser_{TimeStamp} |
      | No Website.Checkbox                         | Y                           |
      | Account Record Sub Type.SingleInputDropdown | Brand                       |
      | Account Approval Status.SingleInputDropdown | Prospect                    |
    Then user deletes the "Brand" record type
