import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttractionSearchPage } from './attraction-search.page';

describe('AttractionSearchPage', () => {
  let component: AttractionSearchPage;
  let fixture: ComponentFixture<AttractionSearchPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttractionSearchPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttractionSearchPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
