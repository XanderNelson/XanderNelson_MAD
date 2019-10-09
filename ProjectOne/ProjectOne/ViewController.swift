//
//  ViewController.swift
//  ProjectOne
//
//  Created by Xander Nelson on 29/09/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBOutlet weak var unitControl: UISegmentedControl!//miles/kilometers
    @IBOutlet weak var calcTypeControl: UISegmentedControl!//speed/distance
    
    @IBOutlet weak var firstTextField: UITextField!
    @IBOutlet weak var firstLabel: UILabel!
    
    @IBOutlet weak var hourTextField: UITextField!
    @IBOutlet weak var hourLabel: UILabel!
    
    @IBOutlet weak var minuteTextField: UITextField!
    @IBOutlet weak var minuteLabel: UILabel!
    
    @IBOutlet weak var calcLabel: UILabel!
    @IBOutlet weak var calcNumberLabel: UILabel!
    
    
    func changeCalc(){
        if calcTypeControl.selectedSegmentIndex == 0{
            if unitControl.selectedSegmentIndex == 0{
                firstLabel.text = "Miles:"
                calcLabel.text = "Average Speed:"
            }
            else{
                firstLabel.text = "Kilometers:"
                calcLabel.text = "Average Speed:"
            }
        }
        else{
            if unitControl.selectedSegmentIndex == 0{
                firstLabel.text = "MPH:"
                calcLabel.text = "Distance:"
            }
            else{
                firstLabel.text = "KMPH:"
                calcLabel.text = "Distance:"
            }
        }
    }
    
    func calculate(){
        var firstText:Float? = Float(firstTextField.text!)
        var hours:Float? = Float(hourTextField.text!)
        var minutes:Float? = Float(minuteTextField.text!)
        var final:Float

        if firstText == nil && firstLabel.text == "MPH:"{
            let speedAlert=UIAlertController(title: "Warning", message: "You must enter a speed amount", preferredStyle: UIAlertController.Style.alert)
            let okButton=UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: {action in
                self.firstTextField.text = "60"
                firstText = 60
            })
            speedAlert.addAction(okButton)
            present(speedAlert, animated: true, completion: nil)
            return
        }
        if firstText == nil && firstLabel.text == "KMPH:"{
            let speedAlert=UIAlertController(title: "Warning", message: "You must enter a speed amount", preferredStyle: UIAlertController.Style.alert)
            let okButton=UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: {action in
                self.firstTextField.text = "96.56"
                firstText = 96.56
            })
            speedAlert.addAction(okButton)
            present(speedAlert, animated: true, completion: nil)
            return
        }
        if hours == nil && minutes == nil{
            let timeAlert=UIAlertController(title: "Warning", message: "You must enter an amount of time", preferredStyle: UIAlertController.Style.alert)
            let okButton=UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: {action in
                self.hourTextField.text = "1"
            })
            timeAlert.addAction(okButton)
            present(timeAlert, animated: true, completion: nil)
            return
        }
        if minutes == nil && hours != nil{
            minutes = 0.0
        }
        if hours == nil && minutes != nil{
            hours = 0.0
        }
        if firstText == nil && (firstLabel.text == "Miles:" || firstLabel.text == "Kilometers:"){
            firstTextField.text = "0"
            firstText = 0.0
        }
        
        if firstLabel.text == "Miles:" || firstLabel.text == "Kilometers:"{
            final = firstText! / (hours!+(minutes!/60))
            calcNumberLabel.text = String(final)
        }
        else{
            
            final = firstText! * (hours!+(minutes!/60))
            calcNumberLabel.text = String(final)
        }
//        else if firstLabel.text == "Kilometers:"{
//            final = firstText! / (hours!+(minutes!/60))
//            calcNumberLabel.text = String(final)
//        }
//        else if firstLabel.text == "MPH:"{
//
//            final = firstText! * (hours!+(minutes!/60))
//            calcNumberLabel.text = String(final)
//        }
//        else{
//
//            final = firstText! * (hours!+(minutes!/60))
//            calcNumberLabel.text = String(final)
//        }
    //PSUEDO CODE
    //this function is checking the first user imput to find what the last calculation label needs
        //with if statements, checking what the first user input says
        //based on what it says, use the above variables to alter the final calculations
        //if firstLabel == miles, calculate speed in mph
        //if firstLabel == MPH, calulate distance in miles
        //if firstLabel == kilometers, calculate speed in kmph
        //if firstLabel == KMPH, calculate distance in kilometers
    }
    @IBAction func goCalc(_ sender: UIButton) {
        calculate()
    }
    @IBAction func updateUnits(_ sender: UISegmentedControl) {
        changeCalc()
    }
    @IBAction func updateType(_ sender: UISegmentedControl) {
        changeCalc()
    }
    
    @IBAction func goButton(_ sender: UIButton) {
    }
    
    override func viewDidLoad() {
        firstTextField.delegate = self
        hourTextField.delegate = self
        minuteTextField.delegate = self
        super.viewDidLoad()
        let tap: UITapGestureRecognizer =
            UITapGestureRecognizer(target: self, action:
                #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        // Do any additional setup after loading the view.
    }
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
}

