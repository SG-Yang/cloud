/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component, ElementRef, ViewChild} from "@angular/core";
import {MenuItem} from "./MenuItem";
import {MenuService} from "./MenuService";
import {FormBuilder, FormGroup} from "@angular/forms";
import {FormulaService} from "./FormulaService";
import {Formula} from "./Formula";
import {Types} from "./Types";
import {AxisService} from "./AxisService";
import {Params} from "./Params";
import {TypeService} from "./TypeService";

@Component({
  selector: 'app-main',
  providers: [MenuService, FormulaService, AxisService,TypeService],
  styles: [`
    form {
      visibility: hidden;
    }
  `],
  template: `<div id="main" style="margin-top: 30px;margin-left: 2%;">
    <section class="w3-container case">
      <nav class="w3-topnav w3-red" style="margin-top: 30px;">
        <a *ngFor="let item of topMenu" (click) = "editP()">{{item.name}}</a>
      </nav>
      <form [ngStyle]="{'visibility': visible,'height': '100px','border': '2px solid #5fee23'}" [formGroup]="editForm">
        <div>
          <label>Type:
            <select formControlName = "formulaType">
                <option value="abc">abc</option>
              <option *ngFor="let type of formulaTypes" value="{{type.name}}">{{type.value}}</option>
            </select>
          </label>
          <label>Name:
            <input type="text" formControlName="formulaName"> 
          </label>
          <label>Formula:
            <textarea formControlName="formulaValue"></textarea>
            <input type="button" (click)="drawDiagram()" value="draw">
          </label>
        </div>
      </form>
        <canvas id="main-graph" #mainGraph width="1020" height="600" style="border:1px solid"></canvas>
    </section>
  </div>`,
})
export class MainComponent /** implements OnInit**/ {
  topMenu: MenuItem[];
  errorMessage: any;
  editForm: FormGroup;
  visible: string;
  @ViewChild('mainGraph') canvas: ElementRef;
  canvasContext: any;
  formula: Formula;
  formulaTypes: Types[];
/**
  ngOnInit() {
    this.initReferences();
    this.canvasContext = this.canvas.nativeElement.getContext('2d');
    this.axisService.drawAxis(this.canvasContext);

  }
 **/

  constructor(private  menuService: MenuService,
              private fb: FormBuilder,
              private formulaService: FormulaService,
              private axisService: AxisService,
              private refService: TypeService
  ) {
    this.createForm();
    this.visible = 'visible';
  }

  initReferences() {
      let params = new Params();
      params.params = ["FormulaMenu",1];

    this.menuService.getItems(params.toPathUrl())
      .subscribe(
        items => this.topMenu = items,
        error => this.errorMessage = <any>error);

    this.refService.getItems("formula").subscribe(
        items => this.formulaTypes = items,
        error => this.errorMessage = <any>error
    );
    console.log(this.formulaTypes);
  }

  editP(event: any ) {
    if (this.visible === 'visible') {
      this.visible = 'hidden';
    } else {
      this.visible = 'visible';
    }
  }

  drawDiagram(event: any ) {
    this.formulaService.postItems(this.editForm.getRawValue()).subscribe(
         formula => this.editForm = this.fb.group(formula),
         error => this.errorMessage = <any>error);
  }

  createForm() {
    this.editForm = this.fb.group({
      formulaValue: '', // <--- the FormControl called "name"
      formulaType: '',
      formulaName: ''
    });
  }
}
