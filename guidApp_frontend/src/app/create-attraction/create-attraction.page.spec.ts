import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAttractionPage } from './create-attraction.page';

describe('CreateAttractionPage', () => {
  let component: CreateAttractionPage;
  let fixture: ComponentFixture<CreateAttractionPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAttractionPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAttractionPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
