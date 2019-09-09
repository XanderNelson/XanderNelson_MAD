//
//  ViewController.swift
//  Lab 1
//
//  Created by Xander Nelson on 04/09/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageSwap: UIImageView!
    @IBOutlet weak var textSwap: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func firstButton(_ sender: UIButton) {
        if sender.tag == 1{
            imageSwap.image = UIImage(named: "mac")
            textSwap.text = "Mac, your hair looks small"
        }
        else if sender.tag == 2{
            imageSwap.image = UIImage(named: "charlie")
            textSwap.text = "Charlie, let them come pay tribute"
        }
    }
}

