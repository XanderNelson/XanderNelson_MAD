//
//  ViewController.swift
//  Midterm1
//
//  Created by Xander Nelson on 14/10/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit
//help from class examples, labs, and project
class ViewController: UIViewController, UITextFieldDelegate {
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBOutlet weak var milesTextField: UITextField!
    @IBAction func monthlyCommuteSwitch(_ sender: UISwitch) {
    }
    @IBOutlet weak var gasTank: UILabel!
    
    @IBOutlet weak var buttonOutlet: UIButton!
    @IBOutlet weak var monthSwitch: UISwitch!
    @IBAction func gasSlider(_ sender: UISlider) {
        let gasAmt=sender.value //float
        gasTank.text=String(format: "Gas in tank: %.0f gallons", gasAmt) //convert float to String
//        let fontSizeCGFloat=CGFloat(fontSize) //convert float to CGFloat
//        titleLabel.font=UIFont.systemFont(ofSize: fontSizeCGFloat) //create a UIFont object and assign to the font property
    }
    @IBAction func segControl(_ sender: UISegmentedControl) {
        commuteCalc(buttonOutlet)
        if vehicleControl.selectedSegmentIndex == 0{
            modeImage.image=UIImage(named: "car_icon")
        }
        else if vehicleControl.selectedSegmentIndex == 1{
            modeImage.image=UIImage(named: "bus_icon")
        }
        else{
            modeImage.image=UIImage(named: "bike_icon")
        }
    }
    
    @IBOutlet weak var modeImage: UIImageView!
    
    @IBOutlet weak var sliderOutlet: UISlider!
    @IBOutlet weak var vehicleControl: UISegmentedControl!
    
    @IBAction func commuteCalc(_ sender: UIButton) {
        let miles:Float? = Float(milesTextField.text!)
        var commutTime:Float
        var gasNeeded:Float
        if monthSwitch.isOn{
            if vehicleControl.selectedSegmentIndex == 0{
                commutTime = ((miles! * 60) / 20) * 20
                gasNeeded = round((miles!)/24) * 20
                
                if gasNeeded > sliderOutlet.value{
                    let speedAlert=UIAlertController(title: "Warning", message: "You do not have enough gas", preferredStyle: UIAlertController.Style.alert)
                    let okButton=UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: {action in
                        self.sliderOutlet.value = gasNeeded
                    })
                    speedAlert.addAction(okButton)
                    present(speedAlert, animated: true, completion: nil)
                    return
                }
                
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = String(gasNeeded) + " gallons"
            }
            else if vehicleControl.selectedSegmentIndex == 1{
                commutTime = (((miles! * 60) / 12) + 10) * 20
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = "0 gallons"
            }
            else{
                commutTime = ((miles! * 60) / 10) * 20
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = "0 gallons"
            }
        }
        else{
            if vehicleControl.selectedSegmentIndex == 0{
                commutTime = (miles! * 60) / 20
                gasNeeded = round((miles!)/24)
                
                if gasNeeded > sliderOutlet.value{
                    let speedAlert=UIAlertController(title: "Warning", message: "You do not have enough gas", preferredStyle: UIAlertController.Style.alert)
                    let okButton=UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: {action in
                        self.sliderOutlet.value = gasNeeded
                    })
                    speedAlert.addAction(okButton)
                    present(speedAlert, animated: true, completion: nil)
                    return
                }
                
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = String(gasNeeded) + " gallons"
            }
            else if vehicleControl.selectedSegmentIndex == 1{
                commutTime = ((miles! * 60) / 12) + 10
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = "0 gallons"
            }
            else{
                commutTime = (miles! * 60) / 10
                commuteTimeLabel.text = String(commutTime) + " mins"
                gasPurchaseLabel.text = "0 gallons"
            }
           
        }
    }
    
    @IBOutlet weak var commuteTimeLabel: UILabel!
    @IBOutlet weak var gasPurchaseLabel: UILabel!
    
    
    
    override func viewDidLoad() {
        milesTextField.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }

}

