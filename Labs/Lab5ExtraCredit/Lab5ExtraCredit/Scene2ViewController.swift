//
//  Scene2ViewController.swift
//  Lab5ExtraCredit
//
//  Created by Xander Nelson on 20/10/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var firstName: UITextField!
    @IBOutlet weak var lastName: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
           if segue.identifier == "doneName"{
               let scene1ViewController = segue.destination as! ViewController
               //check to see that text was entered in the textfields
               if firstName.text!.isEmpty == false{
                   scene1ViewController.user.first=firstName.text
               }
               if lastName.text!.isEmpty == false{
                   scene1ViewController.user.last=lastName.text
               }
           }
       }
    
    override func viewDidLoad() {
        firstName.delegate=self
        lastName.delegate=self
        super.viewDidLoad()
    }
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
         textField.resignFirstResponder()
         return true
     }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
