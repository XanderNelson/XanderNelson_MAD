//
//  ViewController.swift
//  Lab3
//
//  Created by Xander Nelson on 19/09/2019.
//  Copyright © 2019 Xander Nelson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var fordImage: UIImageView!
    @IBOutlet weak var fontColor: UISwitch!
    @IBOutlet weak var fordLabel: UILabel!
    @IBOutlet weak var sizeCheck: UILabel!
    @IBOutlet weak var capControl: UISwitch!
    @IBOutlet weak var textSize: UISlider!
    @IBOutlet weak var imageSwitch: UISegmentedControl!
    @IBOutlet weak var fontLabel: UILabel!
    
    func capsOn(){
        if(capControl.isOn){
            fordLabel.text=fordLabel.text?.uppercased()
        }
        else{
            fordLabel.text=fordLabel.text?.lowercased()
        }
    }
    
    func imageSwap(){
        if imageSwitch.selectedSegmentIndex == 0{
            fordImage.image=UIImage(named: "1966gt")
            fordLabel.text = "Old Ford GT"
        }
        else{
            fordImage.image=UIImage(named: "2017gt")
            fordLabel.text = "New Ford GT"
        }
    }
    
    @IBAction func switchPhotoText(_ sender: UISegmentedControl) {
        imageSwap()
        capsOn()
    }
    
    @IBAction func capUpdate(_ sender: UISwitch) {
        capsOn()
    }
    
    @IBAction func fontSlider(_ sender: UISlider) {
        let size = sender.value
        fontLabel.text=String(format: "%.0f", size)
        let newSize = CGFloat(size)
        fordLabel.font=UIFont.systemFont(ofSize: newSize)
    }
    
    @IBAction func colorSwap(_ sender: UISwitch) {
        if(fontColor.isOn){
            fordLabel.textColor = UIColor.blue
        }
        else{
            fordLabel.textColor = UIColor.black
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
}

