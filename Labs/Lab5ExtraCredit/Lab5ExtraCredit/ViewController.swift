//
//  ViewController.swift
//  Lab5ExtraCredit
//
//  Created by Xander Nelson on 20/10/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var firstLabel: UILabel!
    @IBOutlet weak var secondLabel: UILabel!
    
    
    
    var user = Name()
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        firstLabel.text = user.first
        secondLabel.text = user.last
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

}

