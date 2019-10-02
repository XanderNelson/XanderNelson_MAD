//
//  ViewController.swift
//  Lab 4
//
//  Created by Xander Nelson on 26/09/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    @IBOutlet weak var numDivided: UITextField!
    @IBOutlet weak var numberStepper: UIStepper!
    @IBOutlet weak var stepperLabel: UILabel!
    @IBOutlet weak var answerFinal: UILabel!
    
    @IBAction func numUpdate(_ sender: UIStepper) {
        stepperLabel.text = String(format: "Divided by: " + "%.0f", numberStepper.value)
    }
    func divide(){
        var divNum: Float
        let divBy = numberStepper.value
        var answer: Float
        
        if numDivided.text!.isEmpty{
            divNum = 0.0
            answer = 1
        }
        else if divBy == 0{
            let alert=UIAlertController(title: "Warning", message: "You cannot divide by 0", preferredStyle: UIAlertController.Style.alert)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.numberStepper.value = 1
                self.stepperLabel.text? = "Divided by: 1"
                self.divide()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        else{
            divNum = Float(numDivided.text!)!
            answer = divNum / Float(divBy)
            answerFinal.text = String(answer)
        }
    }
    func textFieldDidEndEditing(_ textField: UITextField) { divide()
    }
    override func viewDidLoad() {
        numDivided.delegate = self
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

