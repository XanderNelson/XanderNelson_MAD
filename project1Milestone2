//
//  ViewController.swift
//  ProjectOne
//
//  Created by Xander Nelson on 29/09/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

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
        var firstText:Float
        var hours:Float
        var minutes:Float
    //PSUEDO CODE
    //this function is checking the first user imput to find what the last calculation label needs
        //with if statements, checking what the first user input says
        //based on what it says, use the above variables to alter the final calculations
        //if firstLabel == miles, calculate speed in mph
        //if firstLabel == MPH, calulate distance in miles
        //if firstLabel == kilometers, calculate speed in kmph
        //if firstLabel == KMPH, calculate distance in kilometers
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
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}
