import {FieldOperation} from "./field-operation";
export class DomainField {
  public constructor(){}
  fieldName: string;
  fieldType: string;
  fieldValue: any;
  selectedOpType: FieldOperation;
  supportedOperationTypes: FieldOperation[];
}
